import React, { useState } from 'react';
import styled from 'styled-components'; 
import ReuniaoService from './ReuniaoService';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


const Header = styled.header`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 8px 0;
  background: #EFCE23; 
`;


const LayoutContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100vh;
  background: white; 
`;

const Input = styled.input`
  margin: 8px;
  padding: 4px;
`;

const Button = styled.button`
  margin: 8px;
  padding: 8px 16px;
  background-color: #EFCE23;
  color: white;
  border: none;
  cursor: pointer;

  &:hover {
    background-color: #E0B409;
  }
`;

function App() {
  const [meetingInfo, setMeetingInfo] = useState({
    titulo: '',
    descricao: '',
    data: '',
    caminhoAudio: '',
  });

  const apiBaseUrl = 'http://localhost:8080/api/reuniao';
  const reuniaoService = new ReuniaoService(apiBaseUrl);

  
  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setMeetingInfo({
      ...meetingInfo,
      [name]: value,
    });
  };

  const handleCreateMeeting = async () => {
    const result = await reuniaoService.criarReuniao(meetingInfo);
  
    if (result) {
      console.log('Reunião criada com sucesso.', result);
      setMeetingInfo({
        titulo: '',
        descricao: '',
        data: '',
        caminhoAudio: '',
      });
  
      // Exibe uma mensagem de sucesso
      toast.success('Reunião criada com sucesso!', {
        position: "top-right",
        autoClose: 3000, // Fecha automaticamente após 3 segundos
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
      });
    }
  };
  

  return (
    <div>
      <Header>
        <h1>SpeakEasy</h1>
      </Header>
      <LayoutContainer>
        <h2>Nova reunião</h2>
        <Input
          type="text"
          placeholder="Título da reunião"
          name="titulo"
          value={meetingInfo.titulo}
          onChange={handleInputChange}
        />
        <Input
          type="text"
          placeholder="Descrição da reunião"
          name="descricao"
          value={meetingInfo.descricao}
          onChange={handleInputChange}
        />
        <Input
          type="text"
          placeholder="Data da reunião"
          name="data"
          value={meetingInfo.data}
          onChange={handleInputChange}
        />
        <Input
          type="text"
          placeholder="Áudio da reunião"
          name="caminhoAudio"
          value={meetingInfo.caminhoAudio}
          onChange={handleInputChange}
        />
        <Button onClick={handleCreateMeeting}>Criar Reunião</Button>
      </LayoutContainer>
      <ToastContainer />
    </div>
  );
}

export default App;
