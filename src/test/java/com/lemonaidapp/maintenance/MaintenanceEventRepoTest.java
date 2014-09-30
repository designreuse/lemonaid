package com.lemonaidapp.maintenance;

import static org.junit.Assert.*;

import com.lemonaidapp.maintenance.MaintenanceEvent;
import com.lemonaidapp.maintenance.MaintenanceEventRepo;
import org.junit.Test;
import org.junit.Assert.*;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;

// TODO Implement tests
public class MaintenanceEventRepoTest {

    private MaintenanceEventRepo eventRepo;
    public MaintenanceEventRepo() {
        this.eventRepo = MaintenanceEventRepo.getInstance();
    }

    List<MaintenanceEvent> events = ArrayList<MaintenanceEvent>;

	@Test
	public void testFindAllEvents() {
        events = eventRepo.findAllEvents();
        Assert.assertTrue(events != null);
        Assert.assertTrue(events.size() == 2);
        events.add(eventRepo.createEvent();
        Assert.assertTrue(events.size() == 3))
	}

	@Test
	public void testFindEventById() {

	}

	@Test
	public void testFindEventsForVehicle() {

	}

	@Test
	public void testCreateEvent() {

	}

}
