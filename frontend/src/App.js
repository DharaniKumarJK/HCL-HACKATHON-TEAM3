import { useEffect, useState } from 'react';
import './App.css';
import { getProducts, createProduct } from './api';

function App() {
  const [products, setProducts] = useState([]);
  const [form, setForm] = useState({ name: '', description: '', price: '', categoryId: '', brandId: '', isAvailable: true });
  const [status, setStatus] = useState('');

  const loadProducts = async () => {
    setStatus('Loading products...');
    try {
      const res = await getProducts();
      setProducts(res.data || []);
      setStatus('');
    } catch (err) {
      console.error(err);
      setStatus('Failed to load products. Is backend running at http://localhost:8080 ?');
    }
  };

  useEffect(() => {
    loadProducts();
  }, []);

  const onSubmit = async (event) => {
    event.preventDefault();
    setStatus('Creating product...');
    try {
      const payload = {
        name: form.name,
        description: form.description,
        price: parseFloat(form.price),
        categoryId: Number(form.categoryId),
        brandId: Number(form.brandId),
        isAvailable: form.isAvailable,
      };
      await createProduct(payload);
      setForm({ name: '', description: '', price: '', categoryId: '', brandId: '', isAvailable: true });
      await loadProducts();
      setStatus('Product created successfully');
    } catch (err) {
      console.error(err);
      setStatus('Failed to create product');
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>CraveCart | React Frontend</h1>
        <p>Using backend API from OpenAPI schema</p>
      </header>

      <section className="status">{status}</section>

      <section className="section">
        <h2>Products</h2>
        <button onClick={loadProducts}>Refresh</button>
        <ul>
          {products.length ? (
            products.map((p) => (
              <li key={p.id || `${p.name}-${Math.random()}`}>
                <strong>{p.name}</strong> - {p.description || 'No description'} - ${p.price}
              </li>
            ))
          ) : (
            <li>No products found.</li>
          )}
        </ul>
      </section>

      <section className="section">
        <h2>Create Product</h2>
        <form onSubmit={onSubmit}>
          <input value={form.name} placeholder="Name" required onChange={(e) => setForm({ ...form, name: e.target.value })} />
          <input value={form.description} placeholder="Description" onChange={(e) => setForm({ ...form, description: e.target.value })} />
          <input value={form.price} placeholder="Price" type="number" step="0.01" required onChange={(e) => setForm({ ...form, price: e.target.value })} />
          <input value={form.categoryId} placeholder="Category ID" type="number" required onChange={(e) => setForm({ ...form, categoryId: e.target.value })} />
          <input value={form.brandId} placeholder="Brand ID" type="number" required onChange={(e) => setForm({ ...form, brandId: e.target.value })} />
          <label>
            Available
            <input type="checkbox" checked={form.isAvailable} onChange={(e) => setForm({ ...form, isAvailable: e.target.checked })} />
          </label>
          <button type="submit">Create product</button>
        </form>
      </section>

      <footer className="App-footer">
        <p>Back end path: <code>http://localhost:8080/api</code></p>
      </footer>
    </div>
  );
}

export default App;
