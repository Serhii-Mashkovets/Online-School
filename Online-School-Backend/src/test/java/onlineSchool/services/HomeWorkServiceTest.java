package java.onlineSchool.services;

import onlineSchool.models.HomeWork;
import onlineSchool.services.HomeWorkService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkServiceTest {

    @Test
    public void testCreateHwNotNull() {
        HomeWorkService homeWorkService = new HomeWorkService();
        HomeWork hw = homeWorkService.createHw();
        assertNotNull(hw);
    }

    @Test
    public void testCreateHwReturnsDifferentObjects() {
        HomeWorkService homeWorkService = new HomeWorkService();
        HomeWork hw1 = homeWorkService.createHw();
        HomeWork hw2 = homeWorkService.createHw();
        assertNotSame(hw1, hw2);
    }

}