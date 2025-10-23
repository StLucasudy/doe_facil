import { pegarAuthorization } from "@/token/index";
import { getToken, removeToken } from "@/token";
import axios from "axios";

export const apiURL = "http://rotaaqui"; // exemplo: https://apibackend.com.br

export const api = axios.create({
  baseURL: apiURL,
});

api.interceptors.request.use(
  (config) => {
    const token = getToken();
    if (token) {
      config.headers["Authorization"] = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

api.interceptors.response.use(
  (response) => {
    pegarAuthorization(response);
    return response;
  },
  (error) => {
    if (error.response?.status === 401) {
      removeToken();
      window.location.href = "/";
    }
    return Promise.reject(error);
  }
);
