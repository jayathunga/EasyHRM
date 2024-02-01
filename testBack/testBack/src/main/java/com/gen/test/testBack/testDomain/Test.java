package com.gen.test.testBack.testDomain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    private String name;

    private String address;




    //Entity relationships
//    @OneToOne(mappedBy = "test",orphanRemoval=true,cascade=CascadeType.PERSIST)
//    private Vehicle vehicle;

//    @OneToMany(mappedBy = "test")
//    private List<Orders> orders=new ArrayList<>();

//    @OneToMany(mappedBy = "test",cascade = CascadeType.ALL)
//    private List<Vehicle>vehicles=new ArrayList<>();

    //
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void merge(Test request) {
        if (request.name != this.name) {
           this.name=request.name;
        }
        if (request.address != this.address) {
            this.address=request.address;
        }

    }
}
