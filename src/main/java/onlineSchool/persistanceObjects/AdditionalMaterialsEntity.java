package onlineSchool.persistanceObjects;


import onlineSchool.models.ResourseType;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Objects;


@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "additional_materials", schema = "onlineschool", catalog = "")
public class AdditionalMaterialsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "add_materials_id")
    private int addMaterialsId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "lecture_id")
    private Integer lectureId;
    @Enumerated(EnumType.STRING)
    @Column(name = "resource_type")
    private ResourseType resourceType;

    public int getAddMaterialsId() {
        return addMaterialsId;
    }

    public void setAddMaterialsId(int addMaterialsId) {
        this.addMaterialsId = addMaterialsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public Object getResourceType() {
        return resourceType;
    }

    public void setResourceType(Object resourceType) {
        this.resourceType = (ResourseType) resourceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalMaterialsEntity that = (AdditionalMaterialsEntity) o;
        return addMaterialsId == that.addMaterialsId && Objects.equals(name, that.name) && Objects.equals(lectureId, that.lectureId) && Objects.equals(resourceType, that.resourceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addMaterialsId, name, lectureId, resourceType);
    }
}
