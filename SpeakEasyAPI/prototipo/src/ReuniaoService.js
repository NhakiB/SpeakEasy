    import axios from 'axios';

    class ReuniaoService {
    constructor(apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    async criarReuniao(dadosReuniao) {
        try {
        const response = await axios.post(`${this.apiBaseUrl}`, dadosReuniao);

        if (response.status === 201) {
            // Reunião criada com sucesso
            return response.data;
        } else {
            // Tratar outros códigos de status aqui, se necessário
            console.error('Erro ao criar a reunião:', response.statusText);
            return null;
        }
        } catch (error) {
        console.error('Erro ao criar a reunião:', error);
        return null;
        }
    }
    }

    export default ReuniaoService;
