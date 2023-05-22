import { Background, Box, Container } from "./styles";
import Stamp from "../../components/Stamp";
import Button from "../../components/Button";

export default function Home({ navigation }) {
  return (
    <Background>
      <Box />
      <Container>
        <Stamp />
        <Button
          title="Página Login"
          onPress={() => navigation.navigate("Login")}
        />
      </Container>
    </Background>
  );
}
