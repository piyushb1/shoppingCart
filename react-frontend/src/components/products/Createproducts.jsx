import React, { Component } from 'react'
import ProductService from '../../services/ProductService';

class CreateProducts extends Component {
    constructor(props) {
        super(props)

        this.state = {            // step 2
            productType: '',
            productName: '',
            category: '',
            price:' ',
            description:' '
        }
        this.changeproductType = this.changeproductType.bind(this);
        this.changeproductName = this.changeproductName.bind(this);
        this.changecategory = this.changecategory.bind(this);
        this.changeprice = this.changeprice.bind(this);
        this.changedescription = this.changedescription.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }

    changeproductType= (event) => {
        this.setState({productType: event.target.value});
    }
    changeproductName= (event) => {
        this.setState({productName: event.target.value});
    }
    changecategory= (event) => {
        this.setState({category: event.target.value});
    }
    changeprice= (event) => {
        this.setState({price: event.target.value});
    }
    changedescription= (event) => {
        this.setState({description: event.target.value});
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
        let product = {
            productType: this.state.productType,
            productName: this.state.productName,
            category: this.state.category,
            price: this.state.price,
            description: this.state.description,
        };
        console.log('product => ' + JSON.stringify(product));

        // step 5
        //if(this.state.id === '_add'){
            ProductService.createProduct(product).then(res =>{
                this.props.history.push('/products');
            });
        // }else{
        //     UserService.updateEmployee(user, this.state.id).then( res => {
        //         this.props.history.push('/employees');
        //     });
        // }
    }
    
    cancel(){
        this.props.history.push('/products');
    }

   
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card offset-md-3 offset-md-3">
                                <div className = "card-body">
                                    <form>
                                        
                                        <div className = "form-group">
                                            <label> Product Name: </label>
                                            <input placeholder="Product Name" type="text" name="lastName" className="form-control" 
                                                value={this.state.productName} onChange={this.changeproductName}/>
                                        </div>
                                        <div className = "form-group">
                                            <label>  Product Type: </label>
                                            <input placeholder="Product Type" type="email" name="firstName" className="form-control" 
                                                value={this.state.productType} onChange={this.changeproductType}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Category: </label>
                                            <input placeholder="Category" type="email" name="firstName" className="form-control" 
                                                value={this.state.category} onChange={this.changecategory}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Price: </label>
                                            <input placeholder="Price" type="email" name="firstName" className="form-control" 
                                                value={this.state.price} onChange={this.changeprice}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Description: </label>
                                            <input placeholder="Description" type="email" name="firstName" className="form-control" 
                                                value={this.state.description} onChange={this.changedescription}/>
                                        </div>
                                       

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Add</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateProducts;
