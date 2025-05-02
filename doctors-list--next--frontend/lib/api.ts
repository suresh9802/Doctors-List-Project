// lib/api.ts
export async function fetchDoctors(filters: any = {}, page: number = 0, size = 10) {
    const params = new URLSearchParams({
      page: page.toString(),
      size: size.toString(),
      ...filters,
    });
  
    const res = await fetch(`http://localhost:8080/api/doctors?${params.toString()}`);
    return await res.json();
  }
  