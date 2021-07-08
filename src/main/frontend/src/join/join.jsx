import { Component } from "react";
import ApiService from'../ApiService';
import styled from'styled-components';
import {Link} from 'react-router-dom';

const JoinPage  = styled.div`
    position:absolute;
    top:45%;
    left:50%;
    width:400px;
    height:570px;
    margin:-280px 0px 0px -200px;
    border:1px solid #c0c0c0;
`
const JoinLogo = styled.img`
    width:300px;
    height:300px;
    margin:0 auto;
    position:relative;
    bottom:80px;
    left:50px;
` 
const JoinId = styled.input`
    width: 350px;
    height: 40px;
    position: relative;
    bottom:170px;
    left:19px;
`
const JoinPwd = styled.input`
    width: 350px;
    height: 40px;
    position: relative;
    bottom:150px;
    left:19px;
`

const JoinName = styled.input`
    width: 350px;
    height: 40px;
    position: relative;
    bottom:130px;
    left:19px;
 `

 const JoinNickname = styled.input`
    width: 350px;
    height: 40px;
    position: relative;
    bottom:110px;
    left:19px;
 `
 const JoinEmail = styled.input`
    width: 350px;
    height: 40px;
    position: relative;
    bottom:90px;
    left:19px;
 `
const CastLabel = styled.label`
    display: inline-block;
    background-color: #d1d1d1;
    padding: 4px 11px;
    font-size: 18px;
    cursor: pointer;
    position:relative;
    bottom:80px;
    left:10px;
    margin-left:10px;
    border-radius:10px 10px 10px 10px;
    width:150px;
    height:30px;
    text-align:center;
    color:white;
`
const NormalLabel = styled.label`
    display: inline-block;
    background-color: #d1d1d1;
    padding: 4px 11px;
    font-size: 18px;
    cursor: pointer;
    position:relative;
    bottom:80px;
    left:10px;
    margin-left:10px;
    border-radius:10px 10px 10px 10px;
    width:150px;
    height:30px;
    text-align:center;
    color:white;
`

const InputCast = styled.input`
    display: none;
    &:checked+${CastLabel}{
        background-color: #76cf9f;
    }
` 

const InputNormal = styled.input`
    display: none;
    &:checked + ${NormalLabel} {
        background-color: #76cf9f;
    }
` 
const JoinSubBtn = styled.input`
    width: 357px;
    height: 50px;
    background-color: rgb(46, 46, 46);
    border: 1px solid rgb(80, 80, 80);
    position: relative;
    text-align: center;
    bottom: 70px;
    left:19px;
    color: white;
    cursor: pointer;
`
export default class Join extends Component{  
    state = {
        message:null,
        memId: '',
        memPassword: '',
        memName:'',
        memRole:'',
        memNickname:'',
        memEmail:''
    }
    handleChange = (e) => {
        this.setState({
          [e.target.name]: e.target.value
        });
      }
    joinUser = (e)=>{
        e.preventDefault();
        let user = {
            memId:this.state.memId,
            memPassword :this.state.memPassword,
            memName : this.state.memName,
            memNickname : this.state.memNickname,
            memEmail: this.state.memEmail,
            memRole : this.state.memRole
        }
        ApiService.addUser(user)
        .then( res => {
            this.setState({
                message: user.memName+'님의 등록이 성공되었습니다.'
            })
            console.log(this.state.message);
            this.props.history.push('/login');
        })
        .catch(err => {
            console.log('addUser() 에러',err);
        })
        
    
    }
    render() {
        return (
        <JoinPage>
            <Link to="/login"><JoinLogo src="img/CC.png"/></Link>
            <form method='post'>
                <JoinId type="text" name="memId" placeholder="ID" onChange={this.handleChange}/>
                <JoinPwd type="password" name="memPassword" autoComplete="off" placeholder="Password" onChange={this.handleChange}/>
                <JoinName type="text" name="memName"placeholder="Name" onChange={this.handleChange}/>
                <JoinNickname type="text" name="memNickname"placeholder="Nickname" onChange={this.handleChange}/>
                <JoinEmail type="email" name="memEmail" placeholder="Email"onChange={this.handleChange}/>
                <InputCast type="radio" id="radio1" name="memRole" value="Cast" onClick={this.handleChange}/>
                <CastLabel htmlFor="radio1">CAST</CastLabel>
                <InputNormal type="radio" id ="radio2"name="memRole" value="Normal" onClick={this.handleChange}/>
                <NormalLabel htmlFor="radio2">일반</NormalLabel>
                <JoinSubBtn type="submit" value="회원가입" onClick={this.joinUser}/>
            </form>
	    </JoinPage>
        );
    }
}
