import axios from 'axios';

const USER_API = "http://localhost:8099/";

class UserService {

    getUsers(){
        return axios.get('http://localhost:8094/' + 'getAll');
    }

    createUser(user){
        return axios.post(USER_API+ 'create' , user);
    }

    getUserById(userid){
        return axios.post(USER_API + 'getById' , userid);
    }

    authenticate(user){
        return axios.post(USER_API + 'authenticate' , user);
    }

    updateUser(user, userid){
        return axios.put(USER_API + 'update/' + userid, user);
    }

    deleteUser(userid){
        return axios.delete(USER_API + 'delete/' + userid);
    }
}

export default new UserService();