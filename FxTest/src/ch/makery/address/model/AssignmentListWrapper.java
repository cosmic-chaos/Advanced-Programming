package ch.makery.address.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of assignments. This is used for saving the
 * list of assignments to XML.
 * 
 */
@XmlRootElement(name = "assignments")
public class AssignmentListWrapper {

    private List<Assignment> assignments;

    @XmlElement(name = "assignment")
    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}