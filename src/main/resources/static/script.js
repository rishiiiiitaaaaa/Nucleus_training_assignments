//api used to perform all operations 
const apiUrl = "http://localhost:8080/api/employees";
const loginUrl = "http://localhost:8080/api/hr/login";

let editingEmployeeId = null;
//DOM manipulation performed
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("loginBtn").addEventListener("click", login);
    document.getElementById("logoutBtn").addEventListener("click", logout);
    document.getElementById("employeeForm").addEventListener("submit", addOrUpdateEmployee);
});

//function for login
function login() {
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    if (!username || !password) {
        document.getElementById("loginMessage").textContent = "Username & Password required!";
        return;
    }

    fetch(loginUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ hrUsername: username, hrPassword: password })
        })
        .then(response => {
            if (!response.ok) throw new Error("Invalid credentials");
            return response.json();
        })
        .then(data => {
            console.log("Login response:", data);
            if (data.message === "Login Successful") {
                document.getElementById("loginPage").style.display = "none";
                document.getElementById("managementPage").style.display = "block";
                fetchEmployees();
            } else {
                throw new Error("Login failed");
            }
        })
        .catch(error => {
            document.getElementById("loginMessage").textContent = error.message;
            console.error("Login error:", error);
        });
}

//function for log out 
function logout() {
    document.getElementById("loginPage").style.display = "block";
    document.getElementById("managementPage").style.display = "none";
    document.getElementById("loginMessage").textContent = "";
}

//function to fetch all employees data
function fetchEmployees() {
    fetch(apiUrl)
        .then(res => {
            if (!res.ok) throw new Error(`HTTP error! Status: ${res.status}`);
            return res.json();
        })
        .then(data => {
            console.log("Fetched employees:", data);
            const tableBody = document.getElementById("employeeTable");
            tableBody.innerHTML = "";

            if (data.length === 0) {
                tableBody.innerHTML = "<tr><td colspan='6'>No employees found</td></tr>";
                return;
            }

            data.forEach(emp => {
                tableBody.innerHTML += `
                    <tr>
                        <td>${emp.empId}</td>
                        <td>${emp.empName}</td>
                        <td>${emp.empDepartment || "-"}</td>
                        <td>${emp.empEmail}</td>
                        <td>${emp.empSalary}</td>
                        <td>
                            <button onclick="editEmployee(${emp.empId})">Edit</button>
                            <button onclick="deleteEmployee(${emp.empId})">Delete</button>
                        </td>
                    </tr>`;
            });
        })
        .catch(error => console.error("Error fetching employees:", error));
}
//function for adding or updating  an employee data
function addOrUpdateEmployee(e) {
    e.preventDefault();

    const employeeData = {
        empId: editingEmployeeId,
        empName: document.getElementById("empName").value,
        empDepartment: document.getElementById("empDepartment").value,
        empEmail: document.getElementById("empEmail").value,
        empSalary: document.getElementById("empSalary").value
    };

    const method = editingEmployeeId ? "PUT" : "POST";
    const url = editingEmployeeId ? `${apiUrl}/${editingEmployeeId}` : apiUrl;

    fetch(url, {
            method: method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(employeeData)
        })
        .then(response => {
            if (!response.ok) throw new Error("Failed to save employee");
            return response.json();
        })
        .then(() => {
            fetchEmployees();
            document.getElementById("employeeForm").reset();
            document.getElementById("submitBtn").textContent = "Add Employee";
            editingEmployeeId = null;
        })
        .catch(error => console.error("Error saving employee:", error));
}

//function for editing an employee
function editEmployee(empId) {
    fetch(`${apiUrl}/${empId}`)
        .then(response => {
            if (!response.ok) throw new Error("Error fetching employee details");
            return response.json();
        })
        .then(emp => {
            console.log("Editing employee:", emp);

            document.getElementById("empName").value = emp.empName || "";
            document.getElementById("empDepartment").value = emp.empDepartment || "";
            document.getElementById("empEmail").value = emp.empEmail || "";
            document.getElementById("empSalary").value = emp.empSalary || "";

            editingEmployeeId = empId;
            document.getElementById("submitBtn").textContent = "Update Employee";
        })
        .catch(error => console.error("Error fetching employee details:", error));
}

//function for deleting an employee
function deleteEmployee(empId) {
    if (!confirm("Are you sure you want to delete this employee?")) return;

    fetch(`${apiUrl}/${empId}`, { method: "DELETE" })
        .then(response => {
            if (!response.ok) throw new Error("Failed to delete employee");
            return response.text();
        })
        .then(() => fetchEmployees())
        .catch(error => console.error("Error deleting employee:", error));
}