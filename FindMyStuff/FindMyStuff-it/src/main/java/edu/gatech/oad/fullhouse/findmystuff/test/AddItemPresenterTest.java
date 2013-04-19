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
import edu.gatech.oad.fullhouse.findmystuff.pres.AddItemPresenter;
import edu.gatech.oad.fullhouse.findmystuff.view.AddItemActivity;

public class AddItemPresenterTest extends
ActivityInstrumentationTestCase2<AddItemActivity> {
	
	private void assertIsFinishing() {
		assertTrue(getActivity().isFinishing());
	}
	
	public AddItemPresenterTest() {
		super(AddItemActivity.class);
	}

	private void assertAddItem(Item expected, Item actual) {
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getStatus(), actual.getStatus());
		assertEquals(expected.getCategory(), actual.getCategory());
		assertEquals(expected.getIncident_id(), actual.getIncident_id());
		
		/*
		assertEquals(testItem.getName(), ((TextView) getActivity()
				.findViewById(R.id.addItemNameField)).getText());
		assertEquals(testItem.getStatus(), ((TextView) getActivity()
				.findViewById(R.id.addItemStatus)).getText());
		assertEquals(testItem.getCategory(), ((Spinner) getActivity()
				.findViewById(R.id.addItemCategoryField)).getSelectedItem().toString());
		assertEquals(testItem.getIncident_id(),((Spinner) getActivity()
				.findViewById(R.id.addItemIncident)).getSelectedItem().toString());
		*/
	}
	
	private class TestItemAccessor implements ItemAccessor {
		
		private Item testItem;
		
		//public TestItemAccessor(Item testItem) {
		//	this.testItem = testItem;
		//}

		public void addItem(Item item) {
			testItem = item;
			//if(!this.testItem.equals(item))
			//if(!(this.testItem.getIncident_id() == item.getIncident_id()))
			//	fail("item not equal to test item");
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
	
	
	public void testAddItemPassed() throws Throwable {
		AddItemActivity activity = getActivity();
		assertNotNull(activity);
		final Item testItem = getTestItem();
		TestItemAccessor accessor = new TestItemAccessor();
		final AddItemPresenter presenter = new AddItemPresenter(activity,
				accessor);
		runTestOnUiThread(new Runnable() {

			public void run() {
				presenter.addItem(testItem);
			}

		});
		Thread.sleep(1000);
		assertIsFinishing();
		assertAddItem(testItem, accessor.testItem);
	}
	
	public void testAddItemFailed() throws Throwable {
		AddItemActivity activity = getActivity();
		assertNotNull(activity);
		final Item testItem = getTestItem2(800);
		TestItemAccessor accessor = new TestItemAccessor();
		final AddItemPresenter presenter = new AddItemPresenter(activity,
				accessor);
		runTestOnUiThread(new Runnable() {

			public void run() {
				presenter.addItem(testItem);
			}

		});
		Thread.sleep(1000);
		assertIsFinishing();
		assertAddItem(testItem, accessor.testItem);
	}
	

}
