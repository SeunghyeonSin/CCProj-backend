import { Component } from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";
const Menu = styled.div`
    width:15%;
    height:2000px;
    background-color:#99CCFF;
`
const MainLogo = styled.img`
    width:300px;
    height:300px;
    position:relative;
    right:7%;
    bottom:2%;

`

const MenuList = styled.ul`
    list-style:none;
    color:white;
    width:100%;
    position:relative;
    right:41px;
    bottom:5%;
    text-align:center;
`

const MenuItem = styled.li`
    width:100%;
    height:50px;
    position:relative;
    cursor:pointer;
`

const MenuItemFont = styled.span`
    position:relative;
    top:15px;
`
const BoardLink = styled(Link)`
    text-decoration:none;
    color:white;
`
export default class MenuBar extends Component {
    render() {
        return (
              <Menu>
                  <MainLogo src="img/CC.png"></MainLogo>
                  <MenuList>
                      <MenuItem><MenuItemFont>마이페이지</MenuItemFont></MenuItem>
                      <MenuItem><BoardLink to = "/fb"><MenuItemFont>자유게시판</MenuItemFont></BoardLink></MenuItem>
                      <MenuItem><MenuItemFont>장터</MenuItemFont></MenuItem>
                      <MenuItem><MenuItemFont>분실물 게시판</MenuItemFont></MenuItem>
                      <MenuItem><MenuItemFont>고객센터</MenuItemFont></MenuItem>
                  </MenuList>
              </Menu>
        );
    }
}
