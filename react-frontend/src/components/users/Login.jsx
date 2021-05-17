import React, { Component } from 'react'
import UserService from '../../services/UserService';

class Login extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            email: '',
            password:''
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }

    // step 3
    // componentDidMount(){

    //     // step 4
    //     if(this.state.id === '_add'){
    //         return
    //     }else{
    //         UserService.getUserById(this.state.id).then( (res) =>{
    //             let employee = res.data;
    //             this.setState({
    //                 password: employee.password,
    //                 emailId : employee.emailId
    //             });
    //         });
    //     }        
    // }
    
    saveOrUpdateEmployee = (e) => {
        e.preventDefault();
        let user = {username: this.state.email, password: this.state.password};
        console.log('user => ' + JSON.stringify(user));

        UserService.authenticate(user).then(res =>{
                console.log('response => ' + JSON.stringify(res));
                let role = res.data.role;
                localStorage.setItem('role',role);
                let jwt = res.data.jwt;
                localStorage.setItem('jwtToken',jwt);
                let userid =res.data.userid;
                localStorage.setItem('userid',userid);

                this.props.history.push('/');
            });
    }
    
    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changePasswordHandler= (event) => {
        this.setState({password: event.target.value});
    }

   
    cancel(){
        this.props.history.push('/products');
    }

    
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                   <h1>Login</h1>
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {/* {
                                    this.getTitle()
                                } */}
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Email: </label>
                                            <input placeholder="Email" type="email" name="firstName" className="form-control" 
                                                value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Password: </label>
                                            <input placeholder="Password" type="text" name="lastName" className="form-control" 
                                                value={this.state.password} onChange={this.changePasswordHandler}/>
                                        </div>
                                        
                                        <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Login</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} >Cancel</button>
                                    </form>

                                    <a>Don't have an Account? </a><a href="/signup">Signup here</a>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default Login