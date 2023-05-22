import { Container, Image, Row, Subtitle, Title } from "./styles";

export default function Stamp() {
  return (
    <Container>
      <Row>
        <Title>SpeakEasy</Title>
        <Image source={require("../../../assets/icon.png")} />
      </Row>
      <Subtitle>Eleve suas reuniões ao próximo nível</Subtitle>
    </Container>
  );
}
