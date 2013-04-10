package edu.gatech.oad.fullhouse.findmystuff.test;

import java.util.Arrays;
import java.util.List;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import edu.gatech.oad.fullhouse.findmystuff.R;
import edu.gatech.oad.fullhouse.findmystuff.dao.ItemAccessor;
import edu.gatech.oad.fullhouse.findmystuff.model.Incident;
import edu.gatech.oad.fullhouse.findmystuff.model.Item;
import edu.gatech.oad.fullhouse.findmystuff.model.User;
import edu.gatech.oad.fullhouse.findmystuff.pres.AddItemPresenter;
import edu.gatech.oad.fullhouse.findmystuff.pres.LookupUserPresenter;
import edu.gatech.oad.fullhouse.findmystuff.view.AddItemActivity;
import edu.gatech.oad.fullhouse.findmystuff.view.LookupUserActivity;

public class AddItemPresenterTest extends
ActivityInstrumentationTestCase2<AddItemActivity> {

	private void assertErrorVisibility(int vis) {
		assertEquals(vis, getActivity().findViewById(R.id.notFoundError)
				.getVisibility());
	}
	
	public AddItemPresenterTest(Class<AddItemActivity> activityClass) {
		super(AddItemActivity.class);
	}

	private void assertAddItem(Item testItem) {
		assertEquals(testItem.getName(), ((TextView) getActivity()
				.findViewById(R.id.addItemNameField)).getText());
		assertEquals(testItem.getStatus(), ((TextView) getActivity()
				.findViewById(R.id.addItemStatus)).getText());
		assertEquals(testItem.getCategory(), ((Spinner) getActivity()
				.findViewById(R.id.addItemCategoryField)).getSelectedItem().toString());
		assertEquals(testItem.getIncident_id(),((Spinner) getActivity()
				.findViewById(R.id.addItemIncident)).getSelectedItem().toString());
	}
	
	private class TestItemAccessor implements ItemAccessor {
		
		private Item testItem;
		
		public TestItemAccessor(Item testItem) {
			this.testItem = testItem;
		}

		public void addItem(Item item) {
			if(!this.testItem.equals(item))
				fail("item not equal to test item");
		}

		public List<Item> getItemsForIncident(Incident incident) {
			if(this.testItem.getIncident_id() == incident.getId())
				return Arrays.asList(this.testItem);
			return null;
		}

		public void updateItem(Item item) {
			fail("updateItem should not be called");
			
		}

		public void deleteItem(Item item) {
			fail("deleteItem should not be called");
			
		}

		public List<Item> searchForItems(String name, String category,
				String status, String date) {
			fail("searchForItems should not be called");
			return null;
		}
		
		private Item getTestItem() {
			Item testItem = new Item();
			testItem.setName("testName");
			testItem.setStatus("testStatus");
			testItem.setCategory("testCategory");
			testItem.setIncident_id(9000);
			return testItem;
		}
		
		private Item getTestItem2(long id) {
			Item testItem = new Item();
			testItem.setName("testName");
			testItem.setStatus("testStatus");
			testItem.setCategory("testCategory");
			testItem.setIncident_id(id);
			return testItem;
		}
		
		public void testAddItemFailed() throws Throwable {
			AddItemActivity activity = getActivity();
			assertNotNull(activity);
			final Item testItem = getTestItem2(800);
			final AddItemPresenter presenter = new AddItemPresenter(activity,
					new TestItemAccessor(testItem));
			runTestOnUiThread(new Runnable() {

				public void run() {
					presenter.addItem(getTestItem2(800));
				}

			});
			Thread.sleep(1000);
			assertErrorVisibility(View.VISIBLE);
		}
		
		public void testAddItemPassed() throws Throwable {
			AddItemActivity activity = getActivity();
			assertNotNull(activity);
			final Item testItem = getTestItem();
			final AddItemPresenter presenter = new AddItemPresenter(activity,
					new TestItemAccessor(testItem));
			runTestOnUiThread(new Runnable() {

				public void run() {
					presenter.addItem(testItem);
				}

			});
			Thread.sleep(1000);
			assertErrorVisibility(View.VISIBLE);
		}
	}

}
