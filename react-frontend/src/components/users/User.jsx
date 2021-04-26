import React, { Component } from 'react'
import EmployeeService from '../../services/EmployeeService';
import UserService from '../../services/UserService';


class User extends Component {
    constructor(props) {
        super(props)

        this.state = {
                employees: []
        }
        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);
        this.logout = this.logout.bind(this);
    }

    deleteEmployee(id){
        EmployeeService.deleteEmployee(id).then( res => {
            this.setState({employees: this.state.employees.filter(employee => employee.id !== id)});
        });
    }
    viewEmployee(id){
        this.props.history.push(`/view-employee/${id}`);
    }
    editEmployee(id){
        this.props.history.push(`/add-employee/${id}`);
    }

    logout(){
        localStorage.removeItem('jwtToken');
        localStorage.removeItem('role');
        this.props.history.push('/users/login');
    }

    componentDidMount(){
        UserService.getUsers().then((res) => {
            this.setState({ employees: res.data});
        });
    }

    addEmployee(){
        this.props.history.push('/users/signup');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Employees List</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addEmployee}> Signup</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Employee First Name</th>
                                    <th> DOB</th>
                                    <th> Gender</th>
                                    <th> Email</th>
                                    <th> Price</th>
                                    <th> Options</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.employees.map(
                                        user => 
                                        <tr key = {user.profileid}>
                                             <td> { user.fullname} </td>   
                                             <td> {user.dateOfBirth}</td>
                                             <td> {user.gender}</td>
                                             <td> {user.email}</td>
                                             <td>
                                                 <button onClick={ () => this.editEmployee(user.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEmployee(user.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(user.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                        <button className="btn btn-danger" onClick={this.logout}>Logout</button>

                 </div>

            </div>
        )
    }
}

export default User
