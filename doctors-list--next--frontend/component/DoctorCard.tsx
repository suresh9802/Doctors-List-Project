// components/DoctorCard.tsx

type DoctorProps = {
    doctor: {
      name: string;
      specialty: string;
      experience: number;
      fee: number;
      rating: number;
      language: string;
      availability: string;
      consultMode: string;
      facility: string;

    };
  };

export default function DoctorCard({ doctor }: any) {
    return (
      <div className="border p-4 rounded shadow-sm">
        <h3 className="text-xl font-semibold">{doctor.name}</h3>
        <p>{doctor.specialty}</p>
        <p>Experience: {doctor.experience} years</p>
        <p>Fee: ₹{doctor.fee}</p>
        <p>Rating: ⭐ {doctor.rating}</p>
        <p>Language: {doctor.language}</p>
        <p>Availability: {doctor.availability}</p>
        <p>consultMode: {doctor.consultMode}</p>
        <p>Facility: {doctor.facility}</p>
      </div>
    );
  }
  