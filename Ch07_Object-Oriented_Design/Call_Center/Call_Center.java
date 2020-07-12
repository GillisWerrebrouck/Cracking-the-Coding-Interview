import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;
import java.util.Queue;

/**
 * Object-oriented design for a call center.
 * 
 * @author Gillis Werrebrouck
 */

public class Call_Center {
    public static void main(final String args[]) {
        ArrayList<Employee> employees = new ArrayList<Employee>(3);
        employees.add(new Employee("Bob", EmployeeType.respondent));
        employees.add(new Employee("Eve", EmployeeType.manager));
        employees.add(new Employee("Tom", EmployeeType.director));

        CallCenter callCenter = new CallCenter(employees);

        Caller caller = new Caller("Karen", "1234");
        Call call = new Call(caller, EmployeeType.respondent);
        Employee employee = callCenter.connectEmployeeToCall(call);
        call.reply("<insert reply>");
        employee.finishCurrentCall();
    }
}

enum EmployeeType {
    respondent,
    manager,
    director,
}

class Employee {
    String name;
    UUID id;
    EmployeeType type;

    private Call currentCall = null;

    public Employee(String name, EmployeeType type) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.type = type;
    }

    public void setCurrentCall(Call currentCall) {
        this.currentCall = currentCall;
    }

    public Call getCurrentCall() {
        return currentCall;
    }

    public void finishCurrentCall() {
        this.currentCall.disconnect();
        this.currentCall = null;
    }

    public void escalateAndReassign() {
        // TODO: add implementation
    }

    public boolean isAvailable() {
        return this.currentCall == null;
    }

    public EmployeeType getType() {
        return type;
    }
}

class Caller {
    private String name;
    private String phoneNumber;

    public Caller(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class Call {
    EmployeeType minEmployeeType = EmployeeType.respondent;
    Caller caller;
    Employee employee;

    public Call(Caller caller) {
        this.caller = caller;
    }

    public Call(Caller caller, EmployeeType minEmployeeType) {
        this.caller = caller;
        this.minEmployeeType = minEmployeeType;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void reply(String message) {
        // TODO: add implementation
    }

    public EmployeeType getMinEmployeeType() {
        return minEmployeeType;
    }

    public void setMinEmployeeType(EmployeeType minEmployeeType) {
        this.minEmployeeType = minEmployeeType;
    }

    public void disconnect() {
        // TODO: add implementation
    }
}

class CallCenter {
    ArrayList<Queue<Call>> callsByEmployeeType = new ArrayList<Queue<Call>>();
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public CallCenter(ArrayList<Employee> employees) {
        this.employees = employees;

        callsByEmployeeType.add(new LinkedList<Call>()); // respondent calls
        callsByEmployeeType.add(new LinkedList<Call>()); // manager calls
        callsByEmployeeType.add(new LinkedList<Call>()); // director
    }

    public Employee connectEmployeeToCall(Call call) {
        // TODO: add correct implementation
        Employee fakeEmployee = new Employee("fakeEmployee", call.minEmployeeType);
        fakeEmployee.setCurrentCall(call);
        return fakeEmployee;
    }

    // route to available employee of corect min type or add to queue
    public void dispatchCall(Call call) {
        // TODO: add implementation
    }
}
