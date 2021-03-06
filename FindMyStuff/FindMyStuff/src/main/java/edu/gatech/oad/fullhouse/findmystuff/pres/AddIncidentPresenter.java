package edu.gatech.oad.fullhouse.findmystuff.pres;

import android.os.AsyncTask;
import edu.gatech.oad.fullhouse.findmystuff.dao.IncidentAccessor;
import edu.gatech.oad.fullhouse.findmystuff.dao.impl.ServerAccessorFactory;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.view.AddIncidentActivity;

/**
 * A presenter for the add incident screen that handles adding an incident to the system
 * 
 * @author Allison Chislett
 *
 */
public class AddIncidentPresenter {

	private AddIncidentActivity activity;
    private IncidentAccessor accessor;

    public AddIncidentPresenter(AddIncidentActivity activ) {
        activity = activ;
        accessor = ServerAccessorFactory.getIncidentAccessor();
    }
    
    /**
     * Puts a given incident into the database. Tells the activity to finish if successful.
     * @param incident the Incident to be added
     */
    public void addIncident(Incident incident) {
        this.activity.setProgressBarIndeterminateVisibility(true); 
	    new AsyncTask<Incident, Void, Void>() {

            @Override
            protected Void doInBackground(Incident ... params) {
                for (Incident inc : params) {
                    accessor.addIncident(inc);
                }
                return null;
            }
	        
            @Override
            protected void onPostExecute(Void result) {
                activity.setProgressBarIndeterminateVisibility(false); 
                activity.finish();
            }
	    }.execute(incident);
	}
    
    
}
