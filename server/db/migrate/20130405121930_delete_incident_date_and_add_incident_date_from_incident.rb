class DeleteIncidentDateAndAddIncidentDateFromIncident < ActiveRecord::Migration
  def change
    remove_column :incidents, :incidentDate
    add_column :incidents, :incident_date, :date
  end
end
