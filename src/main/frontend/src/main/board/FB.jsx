import { Component } from "react";
import styled from "styled-components";
import MenuBar from'../MenuBar';

const FBP = styled.div`
     margin :0;
`
const BoardTitle = styled.p`
    position:relative;
    font-size:25px;
    left:5%;
    top:1%;
    font-weight:bold;
    color:black;
`
const BoardList = styled.div`
    width:50%;
    height:955px;
    position:relative;
    border:1px solid #c0c0c0;
    border-width:0px 1px 0px 0px;
    left:15%;
    bottom:2025px;
    display:flex;
    flex-wrap:wrap;
    overflow:auto;
    color:black;
`
const Board = styled.div`
    width:100%;
    height:45px;
    border:1px solid #c0c0c0;
    border-width:1px 0px 1px 0px;
`
const BName  = styled.span`
    font-size:15px;
    position:relative;
    top:25%;
    left:5%;
`

const BRC =  styled.span`
    float:right;
    position:relative;
    top:23%;
    right:7%;
    font-size:15px;
`
const BWriter = styled.span`
    float:right;
    margin-right:10px;
    position:relative;
    font-size:15px;
    top:25%;
    right:10%;
`
const BInfo = styled.span`
    float:right;
    margin-right:50%;
    position:relative;
    font-size:15px;
    top:25%;
    right:5%;
`

const BoardWrite = styled.div`
    width:34.7%;
    height:890px;
    position:relative;
    left:65.1%;
    bottom:2940px;
    color:black;
`
const BoradWriteTitle = styled.p`
    position:relative;
    font-size:25px;
    left:1%;
    top:5%;
    font-weight:bold;
    color:black;
`
const BoardWriteName = styled.input`
    width:100%;
    height:60px;
    border:1px solid #c0c0c0;
    border-width:1px 0px 1px 0px;
    outline:none;
    font-size:17px;
`
const BoardWriteInfo = styled.textarea`
    outline:none;
    width:100%;
    height:500px;
    border-width:0px 0px 1px 0px;
    resize: none;
`
const BoardWriteForm = styled.form`
    position:relative;
    top:5%;
`
const BoardSubBtn = styled.input`
    width:101%;    
    height: 60px;
    background-color: rgb(46, 46, 46);
    border: 1px solid rgb(80, 80, 80);
    text-align: center;
    color: white;
    cursor: pointer;
`

function repeatUI() {
    var forArray = [];
    for (let i = 0; i < 30; i++) {
        forArray.push(<Board><BName>test입니다</BName><BRC>1</BRC><BWriter>익명</BWriter><BInfo>test글이에요!</BInfo></Board>);
    }
    return forArray;
}
export default class FB extends Component {
    render() {
        return (
            <FBP>
                <MenuBar></MenuBar>
                <BoardList>
                    <BoardTitle>자유게시판</BoardTitle>
                    {repeatUI()}
                </BoardList>
                <BoardWrite>
                    <BoradWriteTitle>글쓰기</BoradWriteTitle>
                    <BoardWriteForm>
                        <BoardWriteName type="text" placeholder="제목을 입력하세요!"/><br></br>
                        <BoardWriteInfo placeholder="내용을 입력하세요!"/>
                        <BoardSubBtn type="submit" value="글등록"/>
                    </BoardWriteForm>    
                </BoardWrite>
            </FBP>
        );
    }
}
