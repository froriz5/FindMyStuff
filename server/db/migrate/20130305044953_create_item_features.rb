class CreateItemFeatures < ActiveRecord::Migration
  def change
    create_table :item_features do |t|
      t.string :name
      t.boolean :hidden

      t.timestamps
    end
  end
end
