import { useState } from "react"

const LoginForm = () => {
    const [user, setUser] = useState({
		email: '',		
		password: '',
	})

	const handleChange = (e) => {
		setUser({
			...user,
			[e.target.name]: e.target.value        
		})   
	}

	const handleSubmit = (e) => {
		e.preventDefault();
		console.log(user);
	}

	const closePayForm = () => {
		/* TODO Cerramos el formulario */
	}
  return (
    <div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50 backdrop-blur-sm z-50 flex items-center justify-center p-4">
			<form className="flex flex-col max-w-[500px] min-w-[550px] mobile:min-w-[300px] bg-white p-10 rounded-lg shadow-md" onSubmit={handleSubmit}>
				<legend className="font-bold text-2xl mb-4">Login</legend>				
				<div>
					<label htmlFor="email" className='block mb-2'>Email</label>
					<input type="email" id="email" name="email" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Email" required onChange={handleChange}/>
				</div>

				<div>
					<label htmlFor="password" className='block mb-2'>Contraseña</label>
					<input type="password" id="password" name="password" className='w-full border-solid border rounded-lg px-2 mb-4 py-2' placeholder="Contraseña" required onChange={handleChange}/>				
				</div>				

				<div className="flex w-full gap-4">
					<button className="w-1/2 bg-[#57D788] py-2 rounded-lg text-white hover:shadow-lg" type="submit">LOGIN</button>
					<button className="w-1/2 bg-[#D7CC57] py-2 rounded-lg text-white hover:shadow-lg" onClick={closePayForm}>CANCELAR</button>
				</div>
			</form>
		</div>
  )
}
export default LoginForm