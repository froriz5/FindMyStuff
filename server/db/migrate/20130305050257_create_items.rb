class CreateItems < ActiveRecord::Migration
  def change
    create_table :items do |t|
      t.string :name
      t.string :category
      t.integer :incident_id
      t.string :status

      t.timestamps
    end
  end
end
