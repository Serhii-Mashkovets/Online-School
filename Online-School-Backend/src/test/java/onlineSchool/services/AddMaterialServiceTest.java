package java.onlineSchool.services;

import onlineSchool.models.AddMaterials;
import onlineSchool.models.Lecture;
import onlineSchool.models.ResourseType;
import onlineSchool.services.AddMaterialService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddMaterialServiceTest {

    @Test
    public void testGroupAddMatByLectures() {
        // given
        List<AddMaterials> materials = new ArrayList<>();
        materials.add(new AddMaterials("Material 1", 1, ResourseType.VIDEO));
        materials.add(new AddMaterials("Material 2", 2, ResourseType.BOOK));
        materials.add(new AddMaterials("Material 3", 1, ResourseType.URL));

        List<Lecture> lectures = new ArrayList<>();
        lectures.add(new Lecture("One", "Lecture 1"));
        lectures.add(new Lecture("Two", "Lecture 2"));

        // when
        AddMaterialService.groupAddMatByLectures(materials, lectures);

        // then
        List<Lecture> expectedLectures = new ArrayList<>();
        expectedLectures.add(new Lecture("",""));

        assertEquals(expectedLectures, lectures);
    }



    @Test
    public void testCreateNewAddMaterial() {
        // given
        System.setIn(new ByteArrayInputStream("1\nTest\n".getBytes()));

        // when
        AddMaterials addMaterial = AddMaterialService.createNewAddMaterial();

        // then
        assertEquals("Test", addMaterial.getName());
        assertEquals(ResourseType.URL, addMaterial.getResourseType());
    }


}