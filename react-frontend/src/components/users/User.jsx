import React, { Component } from 'react'
import UserService from '../../services/UserService';

class User extends Component {
    constructor(props) {
        super(props)

        this.state = {
                employees: [],
                email: '',
                name:'',
                mobilenumber:'',
                gender:'',
                about:'',
                user:[]
        }
        
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeGenderHandler = this.changeGenderHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeMobileHandler = this.changeMobileHandler.bind(this);
        this.changeAbout = this.changeAbout.bind(this);
        this.updateUser = this.updateUser.bind(this);
    }


     
    updateUser = (e) => {

        e.preventDefault();
        let user = {email: this.state.email, gender: this.state.gender, mobilenumber: this.state.mobilenumber,
             fullname: this.state.name, profileid: localStorage.userid, about: this.state.about};
        console.log('user => ' + JSON.stringify(user));

        
        UserService.updateUser(user).then(res =>{
                console.log('response => ' + JSON.stringify(res));
               
                this.props.history.push('/user');
            })

            
    }


    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeGenderHandler= (event) => {
        this.setState({gender: event.target.value});
    }
    
    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changeMobileHandler= (event) => {
        this.setState({mobilenumber: event.target.value});
    }

    changeAbout= (event) => {
        this.setState({about: event.target.value});
    }

    componentDidMount(){
             
        UserService.getUserById(localStorage.userid).then((res) => {
            console.log('user => ' + JSON.stringify(res.data));
            this.setState({ user: res.data});
            this.setState({name: this.state.user.fullname})
            this.setState({mobilenumber: this.state.user.mobilenumber})
            this.setState({email: this.state.user.email})
            this.setState({gender: this.state.user.gender})
            this.setState({about:this.state.user.about})
        });
    }

    addEmployee(){
        this.props.history.push('/users/signup');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">My Profile</h2>
                 <br></br>

                        <form id="contact-form" style={{width:"800px"}} >
                            <div>
                            <div className="form-group">
                                <label htmlFor="name">Name</label>
                                <input placeholder="Enter Name" type="text" name="firstName" className="form-control" 
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                            </div>
                            <div className="form-group">
                                <label htmlFor="exampleInputEmail1">Email address</label>
                                <input type="email" className="form-control"  value={this.state.email} onChange={this.changeEmailHandler} aria-describedby="emailHelp" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="exampleInputEmail1">Gender</label>
                                <input  className="form-control" placeholder="Enter Gender" type="text" name="lastName"
                                                value={this.state.gender} onChange={this.changeGenderHandler} aria-describedby="emailHelp" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="exampleInputEmail1">Contact</label>
                                <input  className="form-control"  placeholder="Enter Contact" type="number" name="firstName"  
                                                value={this.state.mobilenumber} onChange={this.changeMobileHandler} aria-describedby="emailHelp" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="exampleInputEmail1">About</label>
                                <textarea className="form-control"  placeholder="About yourself" type="text" name="about"  
                                                value={this.state.about} onChange={this.changeAbout} aria-describedby="emailHelp" rows="2"></textarea>
                            </div>
                            <button type="submit" onClick={this.updateUser} className="btn btn-primary">Update</button>
                            </div>
                        </form>


            </div>
        )
    }
}

export default User
