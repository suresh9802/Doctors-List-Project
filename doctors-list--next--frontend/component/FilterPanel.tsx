// components/FilterPanel.tsx
import { useState } from "react";

export default function FilterPanel({ setFilters }: any) {
  const [gender, setGender] = useState("");
  const [minExperience, setMinExperience] = useState("");
  const [maxFee, setMaxFee] = useState("");
  const [minRating, setMinRating] = useState("");

  const applyFilters = () => {
    setFilters({
      gender,
      minExperience,
      maxFee,
      minRating,
    });
  };

  return (
    <div className="border p-4 rounded-lg shadow">
      <h2 className="font-semibold mb-2">Filters</h2>

      <label className="block mb-2">
        Gender:
        <select className="w-full" value={gender} onChange={(e) => setGender(e.target.value)}>
          <option value="">All</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>
      </label>

      <label className="block mb-2">
        Min Experience:
        <input className="w-full" type="number" value={minExperience} onChange={(e) => setMinExperience(e.target.value)} />
      </label>

      <label className="block mb-2">
        Max Fee:
        <input className="w-full" type="number" value={maxFee} onChange={(e) => setMaxFee(e.target.value)} />
      </label>

      <label className="block mb-2">
        Min Rating:
        <input className="w-full" type="number" step="0.1" value={minRating} onChange={(e) => setMinRating(e.target.value)} />
      </label>

      <button onClick={applyFilters} className="mt-2 bg-blue-600 text-white px-3 py-1 rounded">
        Apply Filters
      </button>
    </div>
  );
}
