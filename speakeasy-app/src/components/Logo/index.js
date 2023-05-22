import { Container, Image, Title } from "./styles";

export default function Logo() {
  return (
    <Container>
      <Title>SpeakEasy</Title>
      <Image source={require("../../../assets/icon.png")} />
    </Container>
  );
}
