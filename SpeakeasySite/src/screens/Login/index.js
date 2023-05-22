import { Container, Form, Image, Input, Main, Title } from "./styles";
import Button from "../../components/Button";
import Logo from "../../components/Logo";
import { useState } from "react";

export default function Login({ navigation }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  return (
    <Container>
      <Image source={require("../../../assets/back.png")} />
      <Main>
        <Logo />
        <Title>Login</Title>
        <Form>
          <Input
            placeholder="Email"
            placeholderTextColor="#191a1c"
            onChangeText={setEmail}
            value={email}
          />
          <Input
            placeholder="Senha"
            placeholderTextColor="#191a1c"
            onChangeText={setPassword}
            value={password}
            secureTextEntry
          />
        </Form>
      </Main>
      <Button title="Página Home" onPress={() => navigation.navigate("Home")} />
    </Container>
  );
}
