class CreateItemsFeaturesJoinTable < ActiveRecord::Migration
  def change
    create_table :item_features_items, :id => false do |t|
      t.integer :item_id
      t.integer :item_feature_id

    end
  end
end
