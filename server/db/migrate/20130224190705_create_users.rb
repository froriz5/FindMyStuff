class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :username
      t.string :password
      t.integer :location_id
      t.datetime :dateJoined
      t.integer :loginAttempts
      t.boolean :locked
      t.boolean :admin
      t.string :emailAddress
      t.string :phoneNumber

      t.timestamps
    end
  end
end
