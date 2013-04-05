class AddTitleAndLocationToIncident < ActiveRecord::Migration
  def change
    add_column :incidents, :title, :string
    add_column :incidents, :location, :string
  end
end
