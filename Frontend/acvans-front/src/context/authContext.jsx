import {
    createContext,
    useEffect,
    useState
} from "react";

import {
    login as loginService,
    logout as logoutService,
    me
} from "../services/authService";

export const AuthContext = createContext();

export function AuthProvider({
    children
}){
    const [user, setUser] = useState(null);

    const [loading, setLoading] = useState(true);

    useEffect(() => {
        async function carregarUsuario(){
            try{
                const usuario = await me();
                setUser(usuario);
            } catch (error) {
                console.error(error)
                setUser(null);
            } finally { 
                setLoading(false);
            }
        }
        carregarUsuario();
    }, []);

    async function login(email, senha){
        const response = await loginService(email, senha);

        if(response.status === 200){
            const usuario = await me();
            setUser(usuario);
            return usuario;
        }

        return response;
    }

    async function logout(){
        try{
            await logoutService();
        }catch(error){
            console.error(error);
        }finally{
            setUser(null);
        }
    }

    async function refreshUser(){
        try {
            const response = await me();
            setUser(response);
        } catch (error) {
            console.error(error);
        }
    }

    const authenticated = !!user;

    return (
        <AuthContext.Provider
            value={{
                user,
                refreshUser,
                loading,
                authenticated,
                login,
                logout
            }}
        >
            {children}
        </AuthContext.Provider>
    );
}