// app/specialties/general-physician-internal-medicine/page.tsx
"use client";

import { useEffect, useState } from "react";
import Head from "next/head";
import DoctorCard from "@/component/DoctorCard";
import FilterPanel from "@/component/FilterPanel";
import { fetchDoctors } from "../lib/api";

export default function GeneralPhysicianPage() {
  const [doctors, setDoctors] = useState([]);
  const [filters, setFilters] = useState({});
  const [page, setPage] = useState(0);

  useEffect(() => {
    const getData = async () => {
      const data = await fetchDoctors(filters, page);
      setDoctors(data?.content || []);
    };
    getData();
  }, [filters, page]);

  return (
    <>
      <Head>
        <title>General Physician in Internal Medicine | Apollo 247 Clone</title>
        <meta name="description" content="Find top General Physicians for Internal Medicine at Apollo 247. View profiles, fees, and availability." />
        
      </Head>

      <div className="bg-gray-50-100 min-h-screen p-4">
  <h1 className="text-2xl font-bold mb-4">General Physician - Internal Medicine</h1>
  <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
    <FilterPanel setFilters={setFilters} />
    <div className="md:col-span-3 space-y-4">
      {doctors.map((doc: any) => (
        <DoctorCard key={doc.id} doctor={doc} />
      ))}
    </div>
  </div>
</div>
    </>
  );
}
