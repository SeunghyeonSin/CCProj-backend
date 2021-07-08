import axios from 'axios';
const addUserUrl = 'http://localhost:8080/join';
const loginUserUrl = 'http://localhost:8080/login';
class ApiService{   
    addUser(user){
        console.log(user);
        return axios.post(addUserUrl,user);
    }
    loginUser(user){
        console.log(user);
        return axios.post(loginUserUrl,user);
    }
}
export default new ApiService();