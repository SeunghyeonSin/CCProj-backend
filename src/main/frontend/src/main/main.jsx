import { Component } from "react";
import { Link } from "react-router-dom";
import ApiService from "../ApiService";
import styled from "styled-components";
import ImageSlide from './imageSlide';
import MenuBar from'./MenuBar';

const MainPage = styled.div`
     margin :0;
`
const FreeBoard = styled.div`
    width:350px;
    height:235px;
    border:1px solid #c0c0c0;
    position:relative;
    bottom:1667px;
    left:22%;
`
const MarketBoard = styled.div`
    width:350px;
    height:235px;
    border:1px solid #c0c0c0;
    position:relative;
    bottom:1900px;
    left:47%;
`
const LostBoard = styled.div`
    width:350px;
    height:235px;
    border:1px solid #c0c0c0;
    position:relative;
    bottom:2133px;
    left:72%;
`

const BoardFont = styled.p`
    position:relative;
    left:20px;
    font-weight:bold;
    width:350px;
    hegiht:30px;
`
const BoardName = styled.p`
    position:relative;
    left:20px;
    color:gray;
`
const BoardWriter = styled.span`
    float:right;
    position:relative;
    right:40px;
`
const Line = styled.hr`
    border-top: 1px solid #c0c0c0;
    border-width:1px 0px 0px 0px;
    position:relative;
    right:20px;
`
export default class Main extends Component {
    render() {
        return (
            <MainPage>
              <ImageSlide></ImageSlide>
              <MenuBar>
              </MenuBar>
              <FreeBoard>
                <BoardFont>자유 게시판 <Line/></BoardFont>
                <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
                <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
                <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
                <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              </FreeBoard>
              <MarketBoard>
              <BoardFont>장터<Line/></BoardFont>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              </MarketBoard>
              <LostBoard>
              <BoardFont>분실물 게시판<Line/></BoardFont>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              <BoardName>test입니다<BoardWriter>test</BoardWriter><Line/></BoardName>
              </LostBoard> 
            </MainPage>
        );
    }
}
