class Item < ActiveRecord::Base

    has_and_belongs_to_many :item_features

    belongs_to :incident
    delegate :incident_date, :to => :incident
  end
