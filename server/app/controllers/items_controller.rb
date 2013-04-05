class ItemsController < ApplicationController
  # GET /items
  # GET /items.json
  def index
    @items = Item.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @items }
    end
  end

  # GET /items/1
  # GET /items/1.json
  def show
    @item = Item.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @item }
    end
  end

  def search

    # This should be a loop over a hash of potential parameters
    where = ''
    hash = {}
    addAnd = false
    if params[:name]
      if addAnd
        where << ' and '
      end
      where << 'name = :name'
      addAnd = true
    end

    if params[:category]
      if addAnd
        where << ' and '
      end
      where << 'category = :category'
      addAnd = true
    end

    if params[:status]
      if addAnd
        where << ' and '
      end
      where << 'status = :status'
      addAnd = true
    end

    if params[:incidentDate]
      if addAnd
        where << ' and '
      end
      where << 'incidentDate >= :incidentDate'
      addAnd = true
    end
    
    @items = Item.joins("join incidents on incidents.id = incident_id").where(where, request.query_parameters)
    if !@items.empty?
      respond_to do |format|
        format.html # show.html.erb
        format.json { render json: @items }
      end
    else
     # TODO handle errors gracefully...currently, we just raise a 500  
    end
  end

  # GET /items/new
  # GET /items/new.json
  def new
    @item = Item.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @item }
    end
  end

  # GET /items/1/edit
  def edit
    @item = Item.find(params[:id])
  end

  # POST /items
  # POST /items.json
  def create
    @item = Item.new(params[:item])

    respond_to do |format|
      if @item.save
        format.html { redirect_to @item, notice: 'Item was successfully created.' }
        format.json { render json: @item, status: :created, location: @item }
      else
        format.html { render action: "new" }
        format.json { render json: @item.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /items/1
  # PUT /items/1.json
  def update
    @item = Item.find(params[:id])

    respond_to do |format|
      if @item.update_attributes(params[:item])
        format.html { redirect_to @item, notice: 'Item was successfully updated.' }
        format.json { head :ok }
      else
        format.html { render action: "edit" }
        format.json { render json: @item.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /items/1
  # DELETE /items/1.json
  def destroy
    @item = Item.find(params[:id])
    @item.destroy

    respond_to do |format|
      format.html { redirect_to items_url }
      format.json { head :ok }
    end
  end
end
