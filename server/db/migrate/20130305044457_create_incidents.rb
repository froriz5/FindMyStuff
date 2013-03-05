class CreateIncidents < ActiveRecord::Migration
  def change
    create_table :incidents do |t|
      t.date :incidentDate
      t.integer :user_id

      t.timestamps
    end
  end
end
