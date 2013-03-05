class ItemFeaturesController < ApplicationController
  # GET /item_features
  # GET /item_features.json
  def index
    @item_features = ItemFeature.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @item_features }
    end
  end

  # GET /item_features/1
  # GET /item_features/1.json
  def show
    @item_feature = ItemFeature.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @item_feature }
    end
  end

  # GET /item_features/new
  # GET /item_features/new.json
  def new
    @item_feature = ItemFeature.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @item_feature }
    end
  end

  # GET /item_features/1/edit
  def edit
    @item_feature = ItemFeature.find(params[:id])
  end

  # POST /item_features
  # POST /item_features.json
  def create
    @item_feature = ItemFeature.new(params[:item_feature])

    respond_to do |format|
      if @item_feature.save
        format.html { redirect_to @item_feature, notice: 'Item feature was successfully created.' }
        format.json { render json: @item_feature, status: :created, location: @item_feature }
      else
        format.html { render action: "new" }
        format.json { render json: @item_feature.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /item_features/1
  # PUT /item_features/1.json
  def update
    @item_feature = ItemFeature.find(params[:id])

    respond_to do |format|
      if @item_feature.update_attributes(params[:item_feature])
        format.html { redirect_to @item_feature, notice: 'Item feature was successfully updated.' }
        format.json { head :ok }
      else
        format.html { render action: "edit" }
        format.json { render json: @item_feature.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /item_features/1
  # DELETE /item_features/1.json
  def destroy
    @item_feature = ItemFeature.find(params[:id])
    @item_feature.destroy

    respond_to do |format|
      format.html { redirect_to item_features_url }
      format.json { head :ok }
    end
  end
end
