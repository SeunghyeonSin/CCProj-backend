import { Component } from "react";
import ApiService from'../ApiService';
import styled from'styled-components';
const FindPage = styled.div`
    position:absolute;
    top:40%;
    left:50%;
    width:400px;
    height:250px;
    margin:-100px 0px 0px -200px;
    border:1px solid #c0c0c0;
`
const Select = styled.div`
    width:400px;
    height:50px;
`

const FindId = styled.button`
    width:200px;
    height:50px;
    border:1px solid #c0c0c0;
    background-color:white;
    border-width:0px 1px 1px 0px ;
    cursor:pointer;
`
const FindPwd = styled.button`
    width:200px;
    height:50px;
    border:1px solid #c0c0c0;
    background-color:#c0c0c0;
    border-width:0px 0px 1px 0px ;
    cursor:pointer;
`
const InputFindNickname = styled.input`
    width: 350px;
    height: 40px;
    position: relative;
    top:50px;
    left:19px;
`
const InputFindId = styled.input`
    width: 350px;
    height: 40px;
    position: relative;
    bottom:46px;
    left:19px;
`
const FindIdSubBtn = styled.input`
    width: 358px;
    height: 50px;
    background-color: rgb(46, 46, 46);
    border: 1px solid rgb(80, 80, 80);
    position: relative;
    text-align: center;
    top:60px;
    left:19px;
    color: white;
    cursor: pointer;
`
const FindPwdSubBtn = styled.input`
    width: 358px;
    height: 50px;
    background-color: rgb(46, 46, 46);
    border: 1px solid rgb(80, 80, 80);
    position: relative;
    text-align: center;
    left:19px;
    bottom:36px;
    color: white;
    cursor: pointer;
`
const FindPwdForm = styled.form`
    visibility:hidden;
`
function findIdSelect(){
    document.getElementById('findId').style.backgroundColor="white";
    document.getElementById('findIdForm').style.visibility="visible";
    document.getElementById('findPwd').style.backgroundColor="#c0c0c0";
    document.getElementById('findPwdForm').style.visibility="hidden";
}
function findPwdSelect(){
    document.getElementById('findId').style.backgroundColor="#c0c0c0";
    document.getElementById('findIdForm').style.visibility="hidden";
    document.getElementById('findPwd').style.backgroundColor="white";
    document.getElementById('findPwdForm').style.visibility="visible";
}
export default class Find extends Component{  
    state = {
        message:'',
        memNickname:''
    }
    handleChange = (e) => {
        this.setState({
          [e.target.name]: e.target.value
        });
      }
    joinUser = (e)=>{

        let user = {
            memNickname: this.state.memNickname
        }
        ApiService.FindUser(user)
        .then( res => {
            this.setState({
                message: user.memName+'님의 아이디를 찾았습니다!'
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
        <FindPage>
            <Select>
                <FindId id="findId" onClick={findIdSelect}>
                    아이디 찾기
                </FindId>
                <FindPwd id="findPwd" onClick={findPwdSelect}>
                    비밀번호 찾기
                </FindPwd>   
            </Select>
            <form method="post" id="findIdForm">
                <InputFindNickname type="text" name="memNickname" placeholder="가입하실때 입력한 닉네임을 적어주세요!" onChange={this.handleChange}/>
                <FindIdSubBtn type="submit" value="아이디 찾기" onClick={this.joinUser}/>
            </form>
            <FindPwdForm method="post" id="findPwdForm">
                <InputFindId type="text" name="memNickname" placeholder="가입한 아이디를 적어주세요!" onChange={this.handleChange}/>
                <FindPwdSubBtn type="submit" value="비밀번호 재설정" onClick={this.joinUser}/>
            </FindPwdForm>
	    </FindPage>
        );
    }
}
