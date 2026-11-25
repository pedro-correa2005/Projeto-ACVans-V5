
import { useEffect, useState } from "react";

function AutoCompleteInput({
    value,
    onChange,
    onSelect,
    searchFunction,
    placeholder,
    displayField,
    disabled
}) {
    const [options, setOptions] = useState([]);
    const [loading, setLoading] = useState(false);
    const [selectedByClick, setSelectedByClick] = useState(false);

    const visibleOptions =
        !value || value.length < 2 || disabled || selectedByClick
            ? []
            : options;

    useEffect(() => {
        if (selectedByClick) {
            return;
        }

        if (!value || value.length < 2 || disabled) {
            return;
        }

        let cancelled = false;

        const timeout = setTimeout(async () => {
            try {
                setLoading(true);

                const data = await searchFunction(value, 0, "max");

                if (!cancelled) {
                    setOptions(data.content);
                }
            } catch (error) {
                if (!cancelled) {
                    console.error(error);
                    setOptions([]);
                }
            } finally {
                if (!cancelled) {
                    setLoading(false);
                }
            }
        }, 300);

        return () => {
            cancelled = true;
            clearTimeout(timeout);
        };

    }, [value, disabled, searchFunction, selectedByClick]);

    function handleChange(newValue) {
        setSelectedByClick(false);
        onChange(newValue);
    }

    function handleSelect(option) {
        setSelectedByClick(true);
        setOptions([]);
        onSelect(option);
        onChange(option[displayField]);
    }

    return (
        <div className="position-relative">
            <input
                type="text"
                className="form-control"
                value={value ?? ""}
                placeholder={placeholder}
                onChange={(e) => handleChange(e.target.value)}
                disabled={disabled}
            />

            {loading && (
                <div className="small mt-1">
                    Buscando...
                </div>
            )}

            {visibleOptions.length > 0 && (
                <ul className="list-group position-absolute w-100 z-3">
                    {visibleOptions.map(option => (
                        <li
                            key={option.id}
                            className="list-group-item list-group-item-action"
                            onClick={() => handleSelect(option)}
                        >
                            {option[displayField]}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default AutoCompleteInput;
