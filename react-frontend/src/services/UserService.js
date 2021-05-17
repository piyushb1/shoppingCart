import axios from 'axios';

const USER_API = "http://localhost:8099/";

class UserService {

    getUsers(){
        return axios.get("http://localhost:8099/profile/getAll",{
            headers:{
            Authorization: `Bearer ${localStorage.jwtToken}`
        }});
    }

    createUser(user){
        return axios.post(USER_API+ 'create' , user);
    }

    getUserById(userid){
        return axios.get('http://localhost:8094/' + 'getById/' + userid);
    }

    authenticate(user){
        return axios.post(USER_API + 'authenticate' , user);
    }

    updateUser(user){
        return axios.put('http://localhost:8094/' + 'update/' +  localStorage.userid, user);
    }

    deleteUser(userid){
        return axios.delete(USER_API + 'delete/' + userid);
    }
}

export default new UserService();