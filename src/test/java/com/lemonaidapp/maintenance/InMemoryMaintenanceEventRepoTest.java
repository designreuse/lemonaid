package com.lemonaidapp.maintenance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// TODO Implement tests
public class InMemoryMaintenanceEventRepoTest {

    private InMemoryMaintenanceEventRepo eventRepo;

    @Before
    public void setup() {
        this.eventRepo = new InMemoryMaintenanceEventRepo();
    }

    @Test
    public void testEmptyEventRepo() {
        assertEquals("Test that newly initialized repository is empty", 0, this.eventRepo.findAllEvents().size());
    }

	@Test
	public void testCreateEvent() {
        MaintenanceEvent e = new MaintenanceEvent();
        e.setId(12345);
        e.setVehicleName("Test Vehicle");
        this.eventRepo.createEvent(e);

        MaintenanceEvent testEvent = this.eventRepo.findEventById(12345);
        assertNotNull("Newly created event is available in repository", testEvent);
        assertEquals("Test that correct maintenance event is found", "Test Vehicle", testEvent.getVehicleName());
	}

    @Test
    public void testFindById() {
        MaintenanceEvent first = new MaintenanceEvent();
        first.setId(12345);
        first.setVehicleName("First Test Vehicle");
        this.eventRepo.createEvent(first);

        MaintenanceEvent second = new MaintenanceEvent();
        second.setId(56789);
        second.setVehicleName("Second Test Vehicle");
        this.eventRepo.createEvent(second);

        MaintenanceEvent testEvent = this.eventRepo.findEventById(12345);
        assertNotNull("Newly created event is available in repository", testEvent);
        assertEquals("Test that correct maintenance event is found", "First Test Vehicle", testEvent.getVehicleName());
    }

//
//	@Test
//	public void testFindEventById() {
//
//	}
//
//	@Test
//	public void testFindEventsForVehicle() {
//
//	}
//
//	@Test
//	public void testCreateEvent() {
//
//	}

}
