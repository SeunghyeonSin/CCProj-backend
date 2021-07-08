import { Component } from "react";
import { Link } from "react-router-dom";
import ApiService from "../ApiService";
import './login.css';
export default class Join extends Component {
    constructor(props) {
        super(props);
        this.state = {
            memId: '',
            memName: '',
            memPassword:'',
            data : []
        }
    }
    handleChange = (e) => {
        this.setState({
          [e.target.name] : e.target.value
        });
      }
    
    loginUser = (e)=>{
        e.preventDefault();
        let user = {
            memId:this.state.memId,
            memPassword :this.state.memPassword,
        }
        ApiService.loginUser(user)
        .then( res => {
            this.setState({
                data: res.data
            })
            console.log(this.state.data);
            if(this.state.data.memId === undefined){
                alert("로그인 실패!");
                window.location.href='/login';
            }
            else{
                window.sessionStorage.setItem('name',this.state.data.memName);
                window.location.href='/main';
            }
        })
        .catch(err => {
            console.log('loginUser() 에러',err);
        })
    }
    render() {
        return (
            <div>
                <div className="animated-title">
                    <div className="text-top">
                        <div>
                            <span>캐스트들의</span>
                            <span>즐거운 대화 공간</span>
                        </div>
                    </div>
                    <div className="text-bottom">
                        <div>CC 입니다!</div>
                    </div>
                </div>
                <div className="login">
                    <img src="img/CC.png" className="logo" />
                    <form method="post">
                        <input className="inputid" type="text" name="memId" placeholder="ID"  onChange={this.handleChange}/>
                        <input className="inputpassword" type="password" name="memPassword" placeholder="Password" onChange={this.handleChange} />
                        <Link to ="/find" className="find">아이디/비밀번호 찾기</Link>
                        <input type="submit" value="로그인" className="subBtn" onClick={this.loginUser}/>
                    </form>
                    <div className="toinsert">
                        <Link to="/join">
                            <button className="joinBtn">회원가입</button>
                        </Link>
                    </div>
                    <img src="img/google.png" className="google" />
                </div>
            </div>
        );
    }
}
