import ReactDOM from "react-dom/client";
const root = ReactDOM.createRoot(document.getElementById("root"));

const tick = () => {
    root.render(
        <div>
            <h4>Browser's details: {navigator.userAgent}</h4>
        </div>
    );
};
setInterval(tick, 1000);
