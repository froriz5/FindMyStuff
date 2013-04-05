# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20130405042935) do

  create_table "categories", :force => true do |t|
    t.string   "name"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "incidents", :force => true do |t|
    t.date     "incidentDate"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.string   "title"
    t.string   "location"
  end

  create_table "item_features", :force => true do |t|
    t.string   "name"
    t.boolean  "hidden"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "item_features_items", :id => false, :force => true do |t|
    t.integer "item_id"
    t.integer "item_feature_id"
  end

  create_table "items", :force => true do |t|
    t.string   "name"
    t.string   "category"
    t.integer  "incident_id"
    t.string   "status"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "items_item_features", :id => false, :force => true do |t|
    t.integer "item_id"
    t.integer "item_incident_id"
  end

  create_table "users", :force => true do |t|
    t.string   "username"
    t.string   "password"
    t.integer  "location_id"
    t.datetime "dateJoined"
    t.integer  "loginAttempts"
    t.boolean  "locked"
    t.boolean  "admin"
    t.string   "emailAddress"
    t.string   "phoneNumber"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

end
