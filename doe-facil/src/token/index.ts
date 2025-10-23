export function getToken(): string | null {
  const token = localStorage.getItem("Token");
  return token;
}

export function removeToken() {
  return localStorage.removeItem("Token");
}

export function isTokenExpired(): boolean {
  const expirationString = localStorage.getItem("Expiration");

  if (!expirationString) {
    return true;
  }
  const expirationTimestamp = parseInt(expirationString, 10);
  const expirationDate = new Date(expirationTimestamp);
  const currenteDate = new Date();

  if (expirationDate >= currenteDate) {
    return true;
  }

  return false;
}

// export function getUserID(): string | null {
//     return localStorage.getItem("UnitID")
// }

export const pegarAuthorization = (response: any) => {
  const authorizationHeader = response.headers?.authorization || response.headers?.Authorization;

  if (authorizationHeader && authorizationHeader.startsWith("Bearer")) {
    const token = authorizationHeader.replace(/^Bearer\s+/i, "");
    localStorage.setItem("Token", token);
  }
};