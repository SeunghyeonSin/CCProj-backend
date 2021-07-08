import React, {Component} from "react";
import styled from 'styled-components';
import Slider from "react-slick";
import './slick-carousel/slick/slick.css';
import './slick-carousel/slick/slick-theme.css';
const Container = styled.div`
  overflow:hidden;
  width:85%;
  height:273px;
  position : absolute;
  border:1px solid #c0c0c0;
  border-width:0px 0px 1px 0px;
  left : 15%;
`;

const StyledSlider = styled(Slider)`
    .slick-slide div{
      outline: none;
    }
`;

const ImageContainer = styled.div`
  margin: 0 0px;
`;

const Image = styled.img`
height: 273px;
width : 100%;
`;

const items = [
  { id: 1, url: 'img/temp6.jpg' },
  { id: 2, url: 'img/temp7.jpg'},
  { id: 3, url: 'img/temp8.jpg' },
  { id: 4, url: 'img/temp9.png'},
  { id: 5, url: 'img/temp10.png' }
];


export default class ImageSlider extends Component {
  render() {
    const settings = {
      focusOnSelect: true,
      infinite: true,
      autoplay: true,
      speed: 500,
      slidesToShow: 1,
      slidesToScroll: 1,
      arrows: true,
      //centerMode: true,
    };
    return (
      <Container>
        <StyledSlider {...settings}
        >
          {items.map(item => {
            return (
              <div key={item.id}>
                <ImageContainer>
                  <Image src={item.url} />
                </ImageContainer>
              </div>
            );
          })}
        </StyledSlider>
      </Container>
    );
  }
}