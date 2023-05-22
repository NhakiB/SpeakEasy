import styled from "styled-components";

export const Container = styled.View`
  flex: 1;
  justify-content: space-between;
  background-color: #191a1c;
  padding: 40px;
  padding-top: 160px;
`;

export const Image = styled.Image`
  width: 30px;
  position: absolute;
  margin-left: 40px;
  margin-top: 40px;
`;

export const Main = styled.View`
  align-items: center;
  width: 100%;
`;

export const Form = styled.View`
  width: 100%;
  gap: 20px;
`;

export const Title = styled.Text`
  color: #fff;
  font-size: 32px;
  margin-top: 120px;
  margin-bottom: 36px;
`;

export const Input = styled.TextInput`
  height: 40px;
  width: 100%;
  background-color: #fff;
  color: #191a1c;
  border-radius: 8px;
  padding-left: 12px;
`;
